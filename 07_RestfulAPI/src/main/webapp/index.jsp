<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
	<h1>휴대전화 목록</h1>
	<table border="1">
		<thead>
			<tr>
				<th>모델번호</th>
				<th>모델이름</th>
				<th>가격</th>
				<th>제조사명</th>
			</tr>
		</thead>
		<tbody id="list">
		</tbody>
	</table>
	<h1>휴대전화 정보</h1>
	<form id="phoneFrm">
		모델번호 : <input type="text" name="num" id="num"> 모델명 : <input
			type="text" name="model" id="model"> 가격 : <input type="text"
			name="price" id="price"> 제조사 : <select id="vcode"
			name="vcode">
			<option value="10">삼성</option>
			<option value="20">애플</option>
		</select> <br> <input type="button" value="추가하기" id="insert"> <input
			type="button" value="수정하기" id="update"> <input type="button"
			value="삭제하기" id="delete" class="num">
	</form>
	<script>
		function list() {
			$.ajax({
			type: 'get',
			url: 'http://localhost:8081/api/phone',
			dataType: 'json',
			
			success: function(data){
				let html ='';
				console.log(data);
				for(let phone of data){
					html += '<tr>' +
							'<td class="num">' + phone.num + '</td>'+
							'<td>' + phone.model + '</td>'+
							'<td>' + phone.price + '</td>'+
							'<td>' + phone.company.vendor + '</td>'+
							'</tr>';
							console.log(phone);
				 }
		
				 $('#list').html(html);
				
			   	 },
				 error: function(){
				 console.log('시스템 상 에러 발생!');
		    	}
			});
		}
		list();
		$('#list').on('click', '.num', function(){
			$.ajax({
				type: 'get',
				url: 'http://localhost:8081/api/phone/'+$(this).text(),
				dataType: 'json',
				
				
				success: function(phone){
					$('#num').val(phone.num);
					$('#model').val(phone.model);
					$('#price').val(phone.price);
					$("#vcode").val(phone.vcode);
				},
				error: function(){
					console.log('시스템 상 에러 발생!');
				}
			});
		})

		$('#insert').on('click', function() {
			let phone = {
				num: $('#num').val(),
				model: $('#model').val(),
				price: $('#price').val(),
				vcode: $('#vcode').val()
			}
			$.ajax({
				type: 'post',
				url: 'http://localhost:8081/api/phone',
				dataType: 'json',
				data: JSON.stringify(phone),
				contentType: "application/json; charset=utf-8",
			
				success: function(data){
					list();
				},
				error: function(){
					console.log('시스템 상 에러 발생!');
				}
			});
		})
		$('#update').on('click', function() {
			let phone = {
				num: $('#num').val(),
				model: $('#model').val(),
				price: $('#price').val(),
				vcode: $('#vcode').val()
			}
			$.ajax({
				type: 'put',
				url: 'http://localhost:8081/api/phone',
				dataType: 'json',
				data: JSON.stringify(phone),
				contentType: "application/json; charset=utf-8",
			
				success: function(data){
					list();
				},
				error: function(){
					console.log('시스템 상 에러 발생!');
				}
			});
		})
		$('#delete').on('click', function() {
			$.ajax({
				type: 'delete',
				url: 'http://localhost:8081/api/phone/'+$('#num').val(),
				dataType: 'json',
				
				
				success: function(phone){
					list();
				},
				error: function(){
					console.log('시스템 상 에러 발생!');
				}
			});
		})

	
	</script>
</body>
</html>