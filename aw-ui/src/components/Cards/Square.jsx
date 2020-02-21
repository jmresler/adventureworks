import React, { Component } from 'react';

class Square extends Component { 

  constructor(props) {
    super(props);
    this.state = {
      hasError: false,
      color: this.props.color
    }

    this.clickSquare = this.clickSquare.bind(this);
  }

  componentDidMount = () => {

  }

  static getDerivedStateFromError(error) {
    // getDerivedStateFromError -> Update state so the next render will show the fallback UI.
    return { hasError: true };
  }

  componentDidCatch(error, info) {
    // You can also log the error to an error reporting service
  }

  getSnapshotBeforeUpdate = (prevProps, prevState) => {
    console.log('Square getSnapshotBeforeUpdate', prevProps, prevState);
  }

  componentDidUpdate = () => {
    console.log('Square did update');
  }

  componentWillUnmount = () => {
    console.log('Square will unmount');
  }

  clickSquare = event => {
    console.log(event.target.value);
  }

  render () {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }

    let squareStyle = {
      height: 150,
      borderStyle: "1px solid black",
      backgroundColor: this.props.color
    };

    return (
      <div style={squareStyle} onClick={this.clickSquare}>
        
      </div>
    );
  }
}

export default Square;