import { useState } from 'react'
import './Counter.css'
import Button from './Button.js'

export default function Counter(){

    const [count, setCount] = useState(0)

    function incrementParentMethod(incrementBy) {
        setCount(count + incrementBy)
    }

    function decrementParentMethod(incrementBy) {
        setCount(count - incrementBy)
    }

    function resetCounter() {
        setCount(0)
    }

    return (
        <>
            <span className="totalCount">{count}</span>
            <Button incrementBy={10} incrementFunction={incrementParentMethod} decrementFunction={decrementParentMethod}/>
            <Button incrementBy={5} incrementFunction={incrementParentMethod} decrementFunction={decrementParentMethod}/>
            <Button incrementBy={1} incrementFunction={incrementParentMethod} decrementFunction={decrementParentMethod}/>
             <button className="resetButton"  onClick={resetCounter} >Reset</button>
        </>
    )
}
