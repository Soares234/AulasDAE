<template>
  <div>  <div class="jumbotron" style="text-align: center">
    <h1>Courses List</h1>
  </div>
  <b-container>
    <b-button variant="primary">Register New Course</b-button>
    <b-table striped over :items="courses" :fields="fields"/>
  </b-container>

  </div>

</template>

<script>
export default {
  data() {
    return {
      fields: [
        'code',
        'name'],
      courses: []
    }
  }, created() {
    this.$axios.$get('/api/courses')
      .then((courses) => {
        this.courses = courses
      }).catch(error=>{
      this.$bvToast.toast('Error loading courses',
        {
          title:'Error',
          variant:'danger',
          solid:true
        })
    })
  }
}
</script>
