<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Drop SHip</title>
    </head>
    <body>
        <h1> Manual Machine file upload</h1>

        <form method="POST" action="/upload" enctype="multipart/form-data">
            <input type="file" name="files" multiple="multiple" /><br/><br/>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>