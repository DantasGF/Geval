<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/verifica-sessao.jsp"/>
<jsp:include page="includes/topo.jsp"/>
        <div class="barra-inicial">
            <h1>Geval <img src="imagens/icone.png"></h1>
            <div class="links">
                <div class="dropdown">
                    <a href="">Cliente <img src="imagens/drop.png"></a>
                    <div class="conteudo-dropdown">
                        <a href="#">Meus Clientes</a>
                        <a href="#">Cadastrar</a>
                    </div>
                </div>
                
                <div class="dropdown">
                    <a href="">Produto <img src="imagens/drop.png"></a>
                    <div class="conteudo-dropdown">
                        <a href="#">Meus Produtos</a>
                        <a href="#">Cadastrar</a>
                    </div>
                </div>
                
                <div class="dropdown">
                    <a href="#">Sair</a>
                </div>
            </div>
        </div>
        
        <div class="boas-vindas">
            <div class="boas-vindas-titulo"><img src="imagens/mãos.png"> <b>Olá!</b></div>
            <div class="boas-vindas-conteudo">
                Seja bem-vindo(a) <b>${proprietario.nome} ${proprietario.sobrenome}</b><br><br>
                &nbsp&nbsp&nbsp Aqui é o seu novo sistema, no mesmo você estará seguro para
                realizar todos os procedimentos de contas pendentes dos clientes da sua empresa.<br><br>
                
                &nbsp&nbsp&nbsp Se você possui dúvida de como usar o seu novo sistema
                estaremos deixando um tutorial para você.
                <b><a style="color: red; font-size: 16px;" href="">
                        Clicando aqui.</a></b>
                <c:if test="logado == true">
                    Logado
                </c:if>
                <br><br><br>
                <b>- Geval</b>
            </div>
        </div>
    </body>
</html>
