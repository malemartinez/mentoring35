import React, { useEffect } from 'react'

import { connect } from 'react-redux';
import Imagen from './imegen';

const Result = (props) => {
    
  return(
    <div className='imageContainer' >
      <Imagen url = {  props.result1 } />
      <Imagen url = {  props.result2 } />
    </div>
  )
 
}


const stateMapToPros = state => {
  return {
    result1: state.random.result?.dice1,
    result2: state.random.result?.dice2,

  
  }
}


export default connect(stateMapToPros)(Result)
