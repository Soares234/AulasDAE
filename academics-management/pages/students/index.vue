<template>
  <div>
    <div class="jumbotron" style="text-align:center" >
      <h1>Students List</h1>
    </div>
    <b-container>
      <b-button variant="primary">Create Student</b-button>
      <b-table striped over :items="students" :fields="fields">
        <template v-slot:cell(actions)="row"><nuxt-link class="btn btn-link" :to="`/students/${row.item.username}`">Details</nuxt-link>
        </template>
      </b-table><nuxt-link to="/">Back</nuxt-link>
    </b-container>

  </div>
</template>
<script>
export default {
  data() {
    return {
      fields: [
        'username',
        'name',
        'email',
      'actions'],
      students: []
    }
  }, created() {
    this.$axios.$get('/api/students')
      .then((students) => {
        this.students = students
      }).catch(error=>{
        this.$bvToast.toast('Error loading students',
          {
            title:'Error',
            variant:'danger',
            solid:true
          })
    })
  }
}

</script>
