<html>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/alert.jsp" %>
<body>


<div id="login">

  <form class="form-signin" action="login" method="post">     

      <div class="form-label-group">
      
      <label for="usuario">Nombre Usuario</label>
      
        <input type="text" class="form-control"
               name="usuario" 
               
               placeholder="Nombre Usuario" 
               required autofocus>
               
        
      </div>

      <div class="form-label-group">
      
       <label for="password">Contrase�a</label>
        <input type="password" 
               name="password"
             
               class="form-control" 
               placeholder="Contrase�a" required>
               
       
      </div>
     
      <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      
    </form>

</div>



</body>
</html>