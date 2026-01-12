package br.com.dbc.vemser.jedimasters.service;

import br.com.dbc.vemser.jedimasters.utils.TipoEmail;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;
    private final Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String de;

    @Value("${spring.mail.username}")
    private String para;

    // Ex. novo usuário - sendEmail(TipoEmail.NOVO_USUARIO, "Ana", "email@gmail.com", "Criação de conta", null, null)
    // Ex. geral - sendEmail(TipoEmail.INFO, "Ana", "email@gmail.com", "Informação de partida", "Você finalizou uma partida", "Descrição do desempenho.")
    public void sendEmail(TipoEmail tipo, String nomePessoa, String emailPessoa, String assunto, String titulo, String mensagem) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(de);
            mimeMessageHelper.setTo(para);
            mimeMessageHelper.setSubject(assunto);
            mimeMessageHelper.setText(geContentFromTemplate(tipo, nomePessoa, titulo, mensagem), true);

            ClassPathResource header = new ClassPathResource("/header.png");
            ClassPathResource footer = new ClassPathResource("/footer.png");
            mimeMessageHelper.addInline("header", header);
            mimeMessageHelper.addInline("footer", footer);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String geContentFromTemplate(TipoEmail tipo, String nomePessoa, String titulo, String mensagem) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nomePessoa);
        dados.put("email", de);

        if (titulo != null && mensagem != null) {
            dados.put("titulo", titulo);
            dados.put("mensagem", mensagem);
        }

        Template template = fmConfiguration.getTemplate("email-template.ftl");

        if (tipo.toString().equals("NOVO_USUARIO")) {
            template = fmConfiguration.getTemplate("email-template-welcome.ftl");
        }

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

}
