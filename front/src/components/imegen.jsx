import React from 'react'
import { useState , useEffect } from 'react';

const Imagen = ({url}) => {

  const [state, setState] = useState();
  
  useEffect( ()=>{
    
    switch(url){
      
      case(1):
        setState("https://www.random.org/dice/dice1.png")
        break
      
      case (2):
        setState("https://www.random.org/dice/dice2.png" )
        break
      case (3):
          setState("https://www.random.org/dice/dice3.png")
          break
      case (4):
          setState("https://www.random.org/dice/dice4.png"  )
          break
      case (5):
          setState("https://www.random.org/dice/dice5.png")
          break
      case (6):
          setState("https://www.random.org/dice/dice6.png")
          break
    }
  }, [url] )


  return ( 
    <img  src= { state} className="imagen" />
   );
}
 
export default Imagen;