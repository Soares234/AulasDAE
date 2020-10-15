<template>
  <div>
    <div class="jumbotron" style="text-align:center" >
      <h1>Subject List</h1>
    </div>
    <b-container>
      <b-button v-if="!create" variant="primary" @click="toggleCreate()">Create Subject</b-button>
      <b-button v-if="create" variant="primary" @click="toggleCreate()">Back</b-button>
      <create v-if="create===true"></create>
      <b-table striped over :items="subjects" :fields="fields">
      </b-table><nuxt-link to="/">Back</nuxt-link>
    </b-container>


  </div>
</template>
<script>
import Create from "@/pages/subjects/create";
export default {
  components: {Create},
  data() {
    return {
      create:false,
      fields: [
        'code',
        'name',
        'courseCode',
        'subjectName',
        'courseYear',
        'schoolYear',
        'actions'],
      subjects: []
    }
  }, created() {
    this.$axios.$get('/api/subjects')
      .then((subjects) => {
        this.subjects = subjects
      }).catch(error=>{
      this.$bvToast.toast('Error loading subjects',
        {
          title:'Error',
          variant:'danger',
          solid:true
        })
    })
  },methods:{
    toggleCreate(){
      this.create= !this.create;
    }
  }
}

</script>
