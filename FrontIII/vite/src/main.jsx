import React from 'react'
import ReactDOM from 'react-dom'

const Header = (props) => {
  return( 
    <h1>
      {props.titulo}
    </h1>
  )
}

const Part = (props) => {
  return (
    <p>
      {props.part} {props.exercises}
    </p>
  )
}

const Content = (props) => {
  console.log(props.arr);
  return (
    <div>
      {props.arr.map((item, index) =>(
        <Part key={index} part={item.name} exercises={item.exercises}/>
      ))}
    </div>
  )
}

const Total = (props) => {
  return( 
    <p>
      Number of exercises {props.arr.reduce((a,b) => a + b.exercises,0)}
    </p>
  )
}

const App = () => {

  const course = 'Half Stack application development'
  const parts = [
    {
      name: 'Fundamentals of React',
      exercises: 10
    },
    {
      name: 'Using props to pass data',
      exercises: 7
    },
    {
      name: 'State of a component',
      exercises: 14
    }
  ]
  return (
    <div>
      <Header titulo={course}/>
      <Content arr={parts}/>
      <Total arr={parts}/>
    </div>
  )
}

ReactDOM.render(<App />, document.getElementById('root'))