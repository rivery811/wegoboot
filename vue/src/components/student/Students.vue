<template>
<div>
<table class ="table">
	<tr>
		<th>no.</th>
		<th>uid</th>
		<th>pw</th>
		<th>name</th>
		<th>birthday</th>
		<th>gender</th>
		<th>hak</th>
		<th>ban</th>
		<th>score</th>
		<th>role</th>
	</tr>
	<tr v-for="(i,j) of list" :key="j.id">
		<td>{{i.personid}}</td>
		<td>{{i.userid}}</td>
		<td>{{i.passwd}}</td>
		<td>{{i.name}}</td>
		<td>{{i.birthday}}</td>
		<td>{{i.male}}</td>
		<td>{{i.hak}}</td>
		<td>{{i.ban}}</td>
		<td>{{i.score}}</td>
		<td>{{i.role}}</td>
	</tr>

</table>
	<div>
		<button :disabled ="pageNum===0" @click="prevPage">이전</button>
		<span>{{ pageNum + 1 }}</span>
		<button :disabled="pageNum >= pageCount-1" @click="nextPage">다음</button>
	</div>
</div>
</template>
<script>
import axios from 'axios'
export default{
	data(){
		return{
			context:'http://localhost:8080/',
			list:[],
			pageNum:0,
			pageCount:5
		}
		
	},
	created(){
		axios
		.get(`${this.context}/students`)
		.then(res=>{
			alert(`count:${res.data}`)
			this.list = res.data
			
		})
		.catch(()=>{
			alert('fail')
		})
	}
}
</script>
<style scoped>
.table{border: 1px solid black}
.table tr{border: 1px solid black}
.table th{border: 1px solid black}
.table td{border: 1px solid black}
</style>