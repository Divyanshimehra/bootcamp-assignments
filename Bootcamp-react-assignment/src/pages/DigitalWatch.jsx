import React, { useEffect, useState } from 'react'

const DigitalWatch = () => {
    const[time, setTime] = useState(new Date());

    useEffect(()=> {
        const id = setInterval(() => {
            setTime(new Date());
        }, 1000);

        return () => clearInterval(id);
    }, []);

  return (
    <div>
        <h2>Digital Watch</h2>
        <h3>{time.toLocaleTimeString()}</h3>
    </div>
  )
}

export default DigitalWatch