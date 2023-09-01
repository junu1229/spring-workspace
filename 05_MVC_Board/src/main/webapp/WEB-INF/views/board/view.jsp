<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
    <style>
        h1 {
            margin-top: 70px;
        }
        .form-group {
            margin: 20px 0;
        }
    </style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
        <h1>게시글 정보</h1>
        <form>
            <div class="form-group">
                <label for="title">title</label>
                <input type="text" name="title" id="title" class="form-control" readonly value="${board.title}"/>
            </div>
            <div class="form-group">
                <label for="content">content</label>
                <textarea name="content" id="content" cols="30" rows="10" class="form-control" readonly style="resize: none;">${board.content}</textarea>
                <%-- <a href="/board/download?filename=${fn:replace(board.url, '/upload','')}"><img src="${board.url}"/></a> --%>
                <a href="${board.url}" download><img src="${board.url}"/></a>
            </div>
            <div class="form-group">
                <label for="writer">writer</label>
                <input type="text" id="writer" name="writer" class="form-control" value="${board.writer}" readonly>
            </div> 
            <a class="btn btn-outline-warning" href="/board/update?no=${board.no}">수정</a>
            <a class="btn btn-outline-danger" href="/board/delete?no=${board.no}">삭제</a>
        </form>
    </div>
</body>
</html>