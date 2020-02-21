import React, { Component } from 'react';

class Label extends Component {
  
  constructor(props) {
    super(props);

    this.state = {
      hasError: false,
      color: this.props.color,
      text: this.props.text
    }
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

  }

  componentDidUpdate = () => {

  }

  componentWillUnmount = () => {

  }

  render () {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }

    let labelStyle = {
      fontFamily: "sans-serif",
      fontWeight: "bold",
      padding: 13,
      margin: 0
    };

    return (
       <React.Fragment>
         <p style={labelStyle}>{this.props.color}</p>
         <p>{this.props.text}</p>
       </React.Fragment>
    );
  }
}

export default Label;