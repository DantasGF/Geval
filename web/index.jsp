<jsp:include page="includes/topo.jsp"/>
        <center><form action="./LoginProprietario" method="post">
        <div class="caixa-login">
            <h1>Geval <img src="imagens/icone.png"></h1>
            <div class="campos">
                <input name="usuario" required="true" type="text" placeholder="Usuário"><br>
                <input name="senha" required="true" type="password" placeholder="Senha"><br>
                <input id="botao-login" name="entrar" type="submit">
            </div><br>
        </div></center>
    </body>
</html>