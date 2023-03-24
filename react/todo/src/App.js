import './App.css';
import {Component} from 'react';
import Component1 from './components/Component1'
import Component3 from './components/Component3'
import Counter from './components/counter/Counter'

function App() {
  return (
    <div className="App">
        <Counter/>
    </div>
  );
}


function Component2(){
    return (
        <div className="Component2">
            Second Component Function
        </div>
    )
}

class Component4 extends Component{
    render(){
        return (
            <div className="Component4">
                Fourth Component Class
            </div>
        )
    }
}

export default App;
