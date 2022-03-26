import React, { useState } from 'react'
import { connect } from 'react-redux';
import { fetchRandom } from '../actions';

const From = (props) => {// component stateless

  // const [state, setState] = useState();

  const onSubmit = (e) => {
    e.preventDefault();
    props.dispatch(fetchRandom());
  };

  return <div >
    <form onSubmit={onSubmit} className='formContainer'>
      <label className='labelForm' htmlFor="list">Random Dices </label>
      <br />
      <button type="submit" disabled={props.loading} className= "buttonForm">
        Roll dice
      </button>
    </form>
  </div>
}


const stateMapToPros = state => {
  return {
    loading: state.view.loading
  }
}


export default connect(stateMapToPros)(From)
