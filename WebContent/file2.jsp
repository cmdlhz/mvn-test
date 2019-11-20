<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload File</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
<form method="POST" action="/file2" enctype="multipart/form-data">
  <div class="form-group">
    <label>File Upload</label>
    <input type="file" class="form-control" name="fileField">
    <small class="form-text text-muted">Upload an image file.</small>
  </div>
  <div class="form-group">
    <label>ID</label>
    <input type="text" class="form-control" name="id">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>