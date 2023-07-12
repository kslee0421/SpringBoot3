jQuery(document).ready(function(){
	$('.guideText').guideText({});
	$.get('data/data.xml',function(data){
		console.log(data);
		var boards = $(data).find('>data>boards');
		var table = $('#board');
		boards.each(function(i){         //i :인덱스번호 0 부터 순환 fruit 4번순환
			var borad = $(this);  //this는 총 네번 바뀜
			borad.children().each(function(j){
				var text = $(this).text(); //price-> date-> origin->
				var boardContent = table.find('.boardContent').eq(i);
				var content = boardContent.find('>div.content').eq(j+1);
				content.text(text); //text치환
			});
		});
	},'xml');

	$('.accordion').each(function(){
		var class_closed = 'closed';
		var accordion = $(this);
		var allHead = accordion.find('a.head');
		var allContent = accordion.find('ul.content');
		var activeHead = accordion.find('a.active')
		var activeContent =activeHead.next('.content')
		function closeAll(){
			allHead.addClass(class_closed);
			allContent.addClass(class_closed);
		};
		closeAll();
		activeHead.addClass('on');
		activeContent.removeClass(class_closed);
		function open (head, content){
			head.removeClass(class_closed);
			content.removeClass(class_closed);
		};
		allHead.click(function(){
			var head = $(this);
			var content = $(this).next();
			allHead.removeClass('on');
			head.addClass('on');
			content.addClass('on');
			closeAll();
			open(head,content);
		});
	});
});










