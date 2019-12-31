<template>
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
		<td>{{i.id}}</td>
		<td>{{i.userid}}</td>
		<td>{{i.passwd}}</td>
		<td>{{i.name}}</td>
		<td>{{i.birthday}}</td>
		<td>{{i.gender}}</td>
		<td>{{i.hak}}</td>
		<td>{{i.ban}}</td>
		<td>{{i.score}}</td>
		<td>{{i.role}}</td>
	</tr>
</table>
</template>
<script>
import axios from 'axios'
export default{
	data(){
		return{
			context:'http://localhost:8080/',
			list:[]
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