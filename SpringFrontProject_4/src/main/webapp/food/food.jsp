<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
.container{
   margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 900px;
}
</style>
</head>
<body>

<div class="container">
	<h3>믿고 보는 맛집 리스트</h3>
	<hr>
	<div class="row">
		<category1 v-bind:cate1="cate_list1"></category1>	<!-- template 안에 html 불러오는 중 -->
	</div>
	<div style="height:20px"></div>
	<h3>지역별 맛집 리스트</h3>
	<hr>
	<div class="row">
		<category2 v-bind:cate2="cate_list2"></category2>	
	</div>
	<div style="height:20px"></div>
	<h3>메뉴별 맛집 리스트</h3>
	<hr>
	<div class="row">
		<category3 v-bind:cate3="cate_list3"></category3>	
	</div>
</div>

<script>

	Vue.component('category1',{
		// nuew Vue에서 값을 받아와야 함 => new Vue 가 제어한다
		props:['cate1'], 
		template:'<div>' // 맨 위에 루트 태그가 있어야 해서 div 잡아야 함
			+'		<div class="col-md-3" v-for="vo in cate1">'
			+'	  		<div class="thumbnail">'
			+'				<img :src="vo.poster" alt="Lights" style="width:100%">'
			+'		   		<div class="caption">'
			+'		     	<p style="font-size:9px">{{vo.title }}</p>'
			+'		   		</div>'
			+'	  		</div>'
		    +'		</div>'
		    +'	  </div>'
		
	})
	Vue.component('category2',{
		props:['cate2'],
		template:'<div>'
			+'		<div class="col-md-4" v-for="vo in cate2">'
			+'	  		<div class="thumbnail">'
			+'				<img :src="vo.poster" alt="Lights" style="width:100%">'
			+'		   		<div class="caption">'
			+'		     	<p style="font-size:9px">{{vo.title }}</p>'
			+'		   		</div>'
			+'	  		</div>'
		    +'		</div>'
		    +'	  </div>'
	})
	Vue.component('category3',{
		props:['cate3'],
		template:'<div>'
			+'		<div class="col-md-3" v-for="vo in cate3">'
			+'	  		<div class="thumbnail">'
			+'				<img :src="vo.poster" alt="Lights" style="width:100%">'
			+'		   		<div class="caption">'
			+'		     	<p style="font-size:9px">{{vo.title }}</p>'
			+'		   		</div>'
			+'	  		</div>'
		    +'		</div>'
		    +'	  </div>'
	})
	
	new Vue({
		el:'.container',
		data:{
			cate_list1:[],
			cate_list2:[],
			cate_list3:[]
		},
		mounted:function(){
			axios.get('http://localhost/web/food/category.do',{
				params:{
					cno:1
				}
			}).then(response=>{
				console.log(response.data);
				this.cate_list1=response.data;
			})
			
			axios.get('http://localhost/web/food/category.do',{
				params:{
					cno:2
				}
			}).then(response=>{
				console.log(response.data);
				this.cate_list2=response.data;
			})
			
			axios.get('http://localhost/web/food/category.do',{
				params:{
					cno:3
				}
			}).then(response=>{
				console.log(response.data);
				this.cate_list3=response.data;
			})
		}
	})

</script>

</body>
</html>