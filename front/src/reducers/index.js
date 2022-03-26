//reducers
import { combineReducers } from 'redux'



function view(state = {loading: false }, action) {

    switch (action.type) {
        //TODO: refactorizar
        case "view-loading": {
            return {loading: true}
        }
        case "view-loaded": {
            return {loading: false}
        }
        default: return state
    }
}

function random(state = {result: []}, action) {
    switch (action.type) {
        case "random-result": {
            console.log(action.data)
            return { result: action.data }

        }
        default: return state
    }
}
function setImage(state = {image:""}, action){
    switch(action.type){
        case "setImageURL":{
            console.log(action.url)
            switch(action.url){
                case (1):
                    const Url = state.image
                    Url = "https://www.random.org/dice/dice1.png"
                    return { image: Url  }
            }
            return state
        }
        default: return state
}   }


const rootReducer = combineReducers({
    view, random ,setImage
})

export default rootReducer