import React, { Component } from 'react';
import Card from "../Card/Card";
import {Container, Row, Col} from "react-bootstrap";




class CardPanel extends Component { 

  constructor(props) {
    super(props);
    this.state = {
      hasError: false,
      rows: this.props.rows,
      columns: this.props.columns
    }
  
    this.showCard = this.showCard.bind(this);

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

  showCard = (event) => {
    return (
      <></>
      );
  }

  render () {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }

    let gridStyle = {padding:35};
    let containerStyle = {marginLeft:"auto", 
                          marginRight:"auto", 
                          marginTop: 100, 
                          border: "1px solid black", 
                          borderRadius:10, 
                          backgroundColor:"white", 
                          width:800, 
                          height:575
                        };

    return (
      <Container style={containerStyle}>
      <Row className="justify-content-md-center">
        <Col style={gridStyle}>
          <Card color="red" />
        </Col>
        <Col style={gridStyle}>
          <Card color="green"/>
        </Col>
        <Col style={gridStyle}>
          <Card color="black"/>
        </Col>
        </Row>
        <Row>
          <Col style={gridStyle}>
            <Card color="blue"/>
          </Col>
          <Col style={gridStyle}>
            <Card color="purple"/>
          </Col>
          <Col style={gridStyle}>
            <Card color="yellow"/>
          </Col>
        </Row>
      </Container>      
    );
  }
}

export default CardPanel;