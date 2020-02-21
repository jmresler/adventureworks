import React, {Component} from "react";
import { Form, Button, Col } from "react-bootstrap";


let statesProvinces = [{abbrev: "AL", stateName:"Alabama"},
                       {abbrev: "AK", stateName:"Alaska"},
                       {abbrev: "AZ", stateName:"Arizona"},
                       {abbrev: "AR", stateName:"Arkansas"},
                       {abbrev: "CA", stateName:"California"},
                       {abbrev: "CO", stateName:"Colorado"},
                       {abbrev: "CT", stateName:"Connecticut"},
                       {abbrev: "DE", stateName:"Delaware"},
                       {abbrev: "FL", stateName:"Florida"},
                       {abbrev: "GA", stateName:"Georgia"},
                       {abbrev: "HI", stateName:"Hawaii"},
                       {abbrev: "ID", stateName:"Idahoa"},
                       {abbrev: "IL", stateName:"Illinoiis"},
                       {abbrev: "IN", stateName:"Indiana"},
                       {abbrev: "IA", stateName:"Iowa"},
                       {abbrev: "KS", stateName:"Kansas"},
                       {abbrev: "KY", stateName:"Kentucky"},
                       {abbrev: "LA", stateName:"Louisiana"},
                       {abbrev: "ME", stateName:"Maine"},
                       {abbrev: "MD", stateName:"Maryland"},
                       {abbrev: "MA", stateName:"Massachussets"},
                       {abbrev: "MI", stateName:"Michigan"},
                       {abbrev: "MN", stateName:"Minnesotta"},
                       {abbrev: "MS", stateName:"Mississippi"},
                       {abbrev: "MO", stateName:"Missouri"},
                       {abbrev: "MT", stateName:"Montana"},
                       {abbrev: "NE", stateName:"Nebraska"},
                       {abbrev: "NV", stateName:"Nevada"},
                       {abbrev: "NH", stateName:"New Hampshire"},
                       {abbrev: "NJ", stateName:"New Jersey"},
                       {abbrev: "NM", stateName:"New Mexico"},
                       {abbrev: "NY", stateName:"New York"},
                       {abbrev: "NC", stateName:"North Carolina"},
                       {abbrev: "ND", stateName:"North Dakota"},
                       {abbrev: "OH", stateName:"Ohio"},
                       {abbrev: "OK", stateName:"Oklahoma"},
                       {abbrev: "OR", stateName:"Oregon"},
                       {abbrev: "PA", stateName:"Pennsylvania"},
                       {abbrev: "RI", stateName:"Rhode Island"},
                       {abbrev: "SC", stateName:"South Carolina"},
                       {abbrev: "SD", stateName:"South Dakota"},
                       {abbrev: "TN", stateName:"Tennessee"},
                       {abbrev: "TX", stateName:"Texas"},
                       {abbrev: "UT", stateName:"Utah"},
                       {abbrev: "VT", stateName:"Vermont"},
                       {abbrev: "VA", stateName:"Virginia"},
                       {abbrev: "WA", stateName:"Washington"},
                       {abbrev: "WV", stateName:"West Virginia"},
                       {abbrev: "WI", stateName:"Wisconsin"},
                       {abbrev: "WY", stateName:"Wyoming"}];

export default class RegistrationForm extends Component {

    constructor(props) {
        super(props);

        this.state = {
            firstName: '',
            lastName: '',
            addressLineOne: '',
            addressLineTwo: '',
            city: '',
            stateProvince: '',
            zipcode : '',
            emailAddress: '',
            password: '',
            primaryPhone: '',
            cellPhone: ''
        }
    }

    render() {

        return (
            <React.Fragment>
            <Form>
            <Form.Row>
                <Form.Group as={Col} controlId="formGridFName">
                  <Form.Label>First Name</Form.Label>
                  <Form.Control type="text" placeholder="First Name" required />
                </Form.Group>

                <Form.Group as={Col} controlId="formGridLName">
                  <Form.Label>Last Name</Form.Label>
                  <Form.Control type="text" placeholder="Last Name" required />
                </Form.Group>
              </Form.Row>

              <Form.Row>
                <Form.Group as={Col} controlId="formGridEmail">
                  <Form.Label>Email</Form.Label>
                  <Form.Control type="email" placeholder="Enter email" required />
                </Form.Group>

                <Form.Group as={Col} controlId="formGridEmailConfirm">
                  <Form.Label>Confirm Email</Form.Label>
                  <Form.Control type="email" placeholder="Confirm email" required />
                </Form.Group>
              </Form.Row>

              <Form.Row>
                <Form.Group as={Col} controlId="formGridFPassword">
                  <Form.Label>Password</Form.Label>
                  <Form.Control type="password" placeholder="Password" required />
                </Form.Group>

                <Form.Group as={Col} controlId="formGridPasswordConfirm">
                  <Form.Label>Confirm Password</Form.Label>
                  <Form.Control type="password" placeholder="Confirm Password" required />
                </Form.Group>
              </Form.Row>
              <Form.Group controlId="formGridAddress1">
                <Form.Label>Address</Form.Label>
                <Form.Control placeholder="1234 Main St" required />
              </Form.Group>

              <Form.Group controlId="formGridAddress2">
                <Form.Label>Address 2</Form.Label>
                <Form.Control placeholder="Apartment, studio, or floor" />
              </Form.Group>

              <Form.Row>
                <Form.Group as={Col} controlId="formGridCity">
                  <Form.Label>City</Form.Label>
                  <Form.Control placeholder="City"/>
                </Form.Group>

                <Form.Group as={Col} controlId="formGridState">
                  <Form.Label>State</Form.Label>
                  <Form.Control as="select" required>
                    <option>Choose...</option>
                    {
                      statesProvinces.map((nombre, key) =>(<option key={key} value={nombre.abbrev}>{nombre.stateName}</option>))
                    }
                  </Form.Control>
                </Form.Group>

                <Form.Group as={Col} controlId="formGridZip">
                  <Form.Label>Zip</Form.Label>
                  <Form.Control placeholder="Zipcode" />
                </Form.Group>
              </Form.Row>

              <Form.Group id="formGridCheckbox">
                <Form.Check type="checkbox" label="Remember me" />
              </Form.Group>

              <Button variant="primary" type="submit">
                Register
              </Button>
            </Form>
            </React.Fragment>
        );
    }
}