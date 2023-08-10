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
<style type="text/css">
.container-fluid{
	margin-top: 50px;
}
.row{
 	margin: 0px auto;
 	width: 100%;
}
.images:hover {
	cursor:pointer;
}
</style>
</head>
<body>

<div class="container-fluid">
<div class="row">
	<div class="text-right">
		${sessionScope.name } 님 로그인 중입니다 <a href="../member/logout.do" class="btn btn-sm btn-danger">로그아웃</a>
	</div>
</div>
	<div class="row">
		<div class="text-center">
		<button class="btn btn-sm btn-primary" @click="categoryGetData(1)">믿고 보는 맛집 리스트</button>
		<button class="btn btn-sm btn-info" @click="categoryGetData(2)">지역별 맛집 리스트</button>
		<button class="btn btn-sm btn-success" @click="categoryGetData(3)">메뉴별 맛집 리스트</button>	
		</div>	
	</div>
	<div style="height:10px"></div>
	<div class="row">
	<div class="col-sm-7">
		<div class="col-md-4" v-for="vo in cate_list">
			<div class="thumbnail"><!-- 변수를 가져오려면 앞에 클론 : 을 찍어야 한다 -->
				<img :src="vo.poster" style="width:100%" class="images" @click="foodGetList(vo.cno,true)">
				<div class="caption">
					 <p style="font-size:9px">{{vo.title}}&nbsp;</p>
				</div>

			</div>
		</div>
		<!-- 숨겨야 하는 위치 -->
		<div class="col-sm-5" v-show="isShow">
			Hello Vue!!
		</div>
	</div>
	</div>
</div>	
<script>

	new Vue({
		el:'.container-fluid',
		data:{
			cate_list:[],
			food_list:[],
			cate_info:{},
			isShow:false
		},
		mounted(){
			this.categoryGetData(1);
		},
		methods:{
			categoryGetData(cno){
				axios.get('../food/food_category_vue.do',{
					params:{
						cno:cno		// key:매개변수
					}
				}).then(response=>{
					console.log(response.data)
					this.cate_list=response.data
				}).catch(error=>{				// then~catch (try~catch) => javascript에서 error 잡을 때	
					console.log(error.response)
				})	
			},
			foodGetList(cno,bool){
				this.isShow=bool;
			}
		}
	})
</script>

</body>
</html>