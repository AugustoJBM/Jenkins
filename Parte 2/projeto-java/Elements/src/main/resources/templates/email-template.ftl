<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Java Mail</title>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td align="center" valign="top" bgcolor="#F3F3F3"
            style="background-color: #F3F3F3; padding: 32px 16px;">
            <table width="600" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td align="center" valign="top" bgcolor="#FFFFFF"
                        style="background-color: #FFFFFF; font-family: Arial, Helvetica, sans-serif; font-size: 14px; color: #000000; border-radius: 8px; overflow: clip; max-width: 650px;">

                        <img src="cid:header" alt="Header do e-mail" style="width: 100%;" />

                        <div style="padding: 32px 20px">
                            <h1 style="font-family: Georgia; font-size: 20px; color: #542281; font-weight: bold; margin-top: 8px; max-width: 600px;">
                                ${titulo}
                            </h1>

                            <div style="max-width: 450px; line-height: 25px;">
                                <br>Olá ${nome}!
                                <br>${mensagem}
                            </div>
                        </div>

                        <img src="cid:footer" alt="Footer do e-mail" style="width: 100%;" />
                    </td>
                </tr>
            </table></td>
    </tr>
</table>
</body>
</html>