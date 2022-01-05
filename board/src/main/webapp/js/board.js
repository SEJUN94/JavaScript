/**
 * 
 */
//리스트출력
listServer = function(page){
	$.ajax({
		url : '/board/List',
		type : '',
		data : {'page' : page},
		success : function(){},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	});
}