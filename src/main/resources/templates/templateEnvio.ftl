<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Engix</title>
    <style>
        /* Estilos Gerais */
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            max-width: 600px;
            margin: 0 auto;
            background-color: #ffffff;
        }

        /* Cabeçalho Azul */
        .header {
            background-color: #4F3FFF;
            /* Azul */
            padding: 20px;
            text-align: center;
        }

        .header img {
            max-width: 250px;
            height: auto;
            margin-top: 10px;
        }

        /* Corpo do Email */
        .content {
            padding: 30px;
            color: #333333;
        }

        .content p {
            font-size: 16px;
            line-height: 1.5;
        }

        .content ul {
            padding-left: 20px;
            margin-top: 20px;
        }

        .content ul li {
            margin-bottom: 15px;
            font-size: 16px;
        }

        /* Rodapé */
        .footer {
            text-align: center;
            padding: 20px;
            background-color: #fff;
            color: #888888;
            font-size: 14px;
            margin-bottom: 100px;
        }

        /* Links do Rodapé */
        .footer a {
            color: #4F3FFF;
            font-weight: bold;
            text-decoration: none;
            background-color: #ffffff;
        }

        /* Responsividade */
        @media only screen and (max-width: 600px) {
            .content {
                padding: 20px;
                padding-bottom: 10px;
            }

            .header img {
                max-width: 150px;
            }

            .all {
                padding-top: 10px;
            }

            .content p,
            .content ul li {
                list-style-type: none;
                font-size: 14px;
            }


        }
    </style>
</head>

<body>
<table class="all">

    <!-- Cabeçalho Azul -->
    <tr>
        <td class="header">
            <img src="https://i.ibb.co/P62ry3f/Logopng.png" alt="Logopng">
        </td>
    </tr>
    <tr>
        <td class="content">
            <p>Essa pessoa nos aguarda: <span class="text-preto">${fullName}</span>,</p>

            <p>
                Um cliente entrou em contato!!! O dever nos chama.
            </p>

            <ul>
                <li><strong class="text-preto">Nome:</strong> <span>${fullName}</span></li>
                <li><strong class="text-preto">Email:</strong> <span>${email}</span></li>
                <li><strong class="text-preto">Telefone:</strong> <span>${phoneNumber}</span></li>
                <li><strong class="text-preto">Descrição:</strong><span>${description}</span></li>
            </ul>

            <p>
                A vida beira a insanidade;
            </p>

            <p>Agradecemos pela sua confiança em nossos serviços!</p>
        </td>
    </tr>

    <!-- Rodapé -->
    <tr>
        <td class="footer">
            Atenciosamente,<br>
            <strong class="text-preto">Euder</strong><br>
            Co-Fundador<br>
            <a href="https://engix.tech">engix.tech</a>
        </td>
    </tr>
</table>
</body>

</html>