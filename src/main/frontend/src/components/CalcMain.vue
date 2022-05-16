<template>
  <div class="container">
    <form>
      <div class="row">
        <div class="form-group col-md-6">
          <input type="text" v-model="operand1" class="form-control" placeholder="Operand 1" />
        </div>
        <div class="form-group col-md-6">
          <input type="text" v-model="operand2" class="form-control" placeholder="Operand 2" />
        </div>
      </div>
      <div class="row">
        <select name="math-operations" id="math-operations" v-model="op">
          <option value="add">Addition</option>
          <option value="subtract">Subtraktion</option>
          <option value="multiply">Multiplikation</option>
          <option value="divide">Division</option>
        </select>
            </div>
            <button @click="calculateResultGet()" type="button" class="btn btn-danger">Berechnen (GET)</button>
            <button @click="calculateResultPost()" type="button" class="btn btn-danger">Berechnen (POST)</button>
      <div class="row">
        <div class="col-md-7 mrgnbtm">
          <div class="display-board">
            <div class="number">
                {{calcResult}}
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>
</template>


<script>
export default {
  name: 'CalcMain',
  data() {
    return {
      operand1: 0,
      operand2: 0,
      op: '',
      calcResult: 0
    }
  },
  methods: {
    async calculateResultPost() {
      const response = await fetch('/compute', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
          operand1: this.operand1,
          operand2: this.operand2,
          op: this.op
        })
      })
      const responseCode = await response.status
      const data = await response.json()
      if (responseCode >= 400) {
        this.calcResult = data.message
      } else {
        this.calcResult = data.result
      }
    },
    async calculateResultGet() {
      const response = await fetch('/compute?operand1=' + this.operand1 + '&operand2=' + this.operand2 + '&op=' + this.op)
      const responseCode = await response.status
      const data = await response.json()
      if (responseCode >= 400) {
        this.calcResult = data.message
      } else {
        this.calcResult = data.result
      }
    }
  }
}
</script>