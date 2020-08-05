import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'
import app from './modules/app'
import user from './modules/user'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    app,
    user
  },
  plugins: [
    createPersistedState({
      key: 'startapp',
      paths: ['app.drawer', 'app.locale', 'app.countries', 'app.cartStatus']
    })
  ]
})

export default store
