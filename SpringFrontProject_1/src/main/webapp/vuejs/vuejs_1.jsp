<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script> 
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
	.container {
		margin-top:50px;
	}
	.row {
		margin:0px auto;
		width:960ps;
	}
</style>

<!-- <script type="text/javascript">
$(function(){
	$('#msg').keyup(function(){
		let m=$('#msg').val();
		$('#print').text(m);
	})
})
</script> -->

</head>
<body>

<div class="container">
	<div class="row">
		입력:<input type="text" v-model="msg" size="30" class="input-sm">
		<div id="print">		
			{{msg}}
			<!-- v-model="msg"에 저장된 내용을 출력한다 -->
		</div>
	</div>
</div>

<!-- 
	 v-model msg에 저장된 내용을 출력
	 v-model => 멤버변수에 값을 변경
-->

<script>
	new Vue({
		el:'.container',
		data:{
			msg:''
		}
	})
</script>


<!-- 
	1.VueJS의 생명주기 : 
	(함수)
		beforeCreate
		created
		------------- vue 객체 생성
		beforeMount 	(메모리에 올릴 때)
		mounted 		(메모리에 저장된 상태)
		------------- 메모리에 저장
		beforeUpdate
		updated
		------------- 수정
		beforeDestroy
		destroyed
		------------- 메모리 해제
		가상돔 : 게임 (더블 버퍼링) => 메모리를 두 개 생성 (가상메모리 => 실제 메모리에 저장)
		String => 메모리와 연결, StringBuffer		
		
	=> DOM(Document Object Model)
		: 트리 형태로 저장된 상태
	=> 추가된 부분만 가상돔에 추가 vueJs
	
	2. 디렉티브
		제어문
			v-for : 반복문 => 태그 (div v-for="">	 : 태그안에 들어가져있다)
			v-if / v-else
			v-show 
		이벤트
			v-on:click => <button v-on:click="aaa()">
			v-on:change
		양방향통신 vuejs / 단방향통신 react
		------- AngularJS 
	
	3. 컴포넌트
		Vue.Component('modal'),
			template:'<html>...'
			
	4. 데이터를 읽어서 출력 (클라이언트 - 서버 통신) = axios
		axios.get('url', {
			parameter:{
				데이터 전송
			}
		}).then(){결과값 읽는 부분}
		=> 일반 문자열 / JSON => @RestController
		=> id나 class를 사용하지 않고, ref="" 이용
	
	5. 라우터 (화면 변경) => Spring에서 화면 변경
		=> 검색, 로그인 처리, 댓글
	
	6. VueJS 생성 과정
		<script>
			new Vue({
				el: .container		=> 제어 영역 => class=".container" / id="#row"
				data:{
					=> 멤버변수 (Vue에서 제어하는 변수)
					a:[] => 스프링에서 전송할 때 => ArrayList (JSonArray로 변경해서 보내야 함)
					b:{} => VO (JsonObject)
					c:true => boolean
					d:'' => String
					e:0 = 정수 / 상수
				}
				생명주기 함수 이용
				mounted:function(){}
				updated:function(){}
				사용자 정의 함수 => 이벤트
				methods: {
					aaa:function(){}
				}
				filters: 변환 (날짜, 숫자)
				-------- complete
			})
		</script>
		
		** 데이터 출력 과정 (내에서 설정한 변수만 사용 가능)
		{{data에 설정된 변수만 사용}}
		=> 한 번에 데이터를 출력 => {{$data}} => 설정된 모든 변수를 볼 수 있다
		=> <img src="{{}}"> => 오류 발생
		=> <img :src="poster"> (poster가 변수명)
		=> : => <input type="text" :value="id"> => v-bind
												   ------- 생략 가능 클론 : 으로 대체
												   
		 	
 -->

</body>
</html>