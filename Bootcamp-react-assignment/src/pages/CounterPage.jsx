import React, { useState } from 'react'

const CounterPage = () => {
    const [count, setCount] = useState(0);
    
  return (
    <div>
        <h2>CounterPage</h2>
        <h3>{count}</h3>
        <button onClick={() => setCount(count+1)}>+</button>
        <button onClick={() => setCount(count-1)}>-</button>
    </div>
  )
}

export default CounterPage