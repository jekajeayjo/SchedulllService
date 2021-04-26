import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import createPersistedState from 'vuex-persistedstate';
//ОБщие контроллеры
import GeneralController from "./GeneralController";
import AuthorizationController from "./AuthorizationController";
import DictionaryController from "./DictionaryController";



export default new Vuex.Store({

    modules: {
        generalController: GeneralController,
        dictionaryController: DictionaryController,
        authorizationController: AuthorizationController,

    },
    plugins: [createPersistedState()]
})