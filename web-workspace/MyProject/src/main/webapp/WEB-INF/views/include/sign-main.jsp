<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <title>Bootstrap Example</title>
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
  </head>
  <style>
  .mb-3 
  </style>
<body>
<div style="width: 600px; margin: auto" >
  <form action="signup.do" method="post">
  
    <div class="mb-3">
      <label for="exampleInputId" class="form-label">ID</label>
      <input type="text" class="form-control" name="userId" aria-describedby="idHelp" maxlength="12" required="required" ">
      <div id="idHelp" class="form-text">아이디는 영문자 및 숫자 0~9 8자 이내로 적어주세요</div>
    </div>
    
    <div class="mb-3">
      <label for="exampleInputPassword1" class="form-label">Password</label>
      <input type="password" class="form-control" name="userPwd" required="required" maxlength="8">
      <div id="passWordHelp" class="form-text">비밀번호는 영문자 및 숫자 0~9 8자 이내로 적어주세요</div>
    </div>
    
    <div class="mb-3">
      <label for="exampleInputName" class="form-label">Name</label>
      <input type="text" class="form-control" name="userName" required="required">
    </div>
    
    <div class="mb-3">
      <label for="exampleInputPhone" class="form-label">Phone</label>
      <input type="text" class="form-control" name="phone" required="required">
    </div>
    
      <div class="mb-3">
      <label for="exampleInputEmail" class="form-label">Email</label>
      <div style="display: flex;">
      <input type="text" class="form-control" name="email" required="" style=" width: 300px;">
      <p >@</p>
      <input type="text" class="form-control" name="email2" required=""style=" width: 300px;" >
      </div>
    </div>
    
    <button type="submit" class="btn btn-primary">아이디 생성</button>
    </form>
    </div>
</body>
</html>