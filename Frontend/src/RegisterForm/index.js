import React, { Component } from "react";
import {
  FormGroup,
  ControlLabel,
  FormControl,
  Checkbox,
  Button
} from "react-bootstrap";
import styled from "styled-components";

class RegisterForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      id: "",
      ladders: [
        {
          name: "epee",
          selected: false
        },
        {
          name: "foil",
          selected: false
        },
        {
          name: "sabre",
          selected: false
        }
      ]
    };
  }

  updateName(event) {
    const newName = event.target.value;
    this.setState({ name: newName });
  }

  updateId(event) {
    const newId = event.target.value;
    this.setState({ id: newId });
  }

  updateCheckbox(event) {}

  render() {
    return (
      <RegisterWindow>
        <form>
          <FormGroup controlId="formBasicText">
            <ControlLabel>Name</ControlLabel>
            <FormControl
              type="text"
              value={this.state.name}
              placeholder="Enter your name"
              onChange={event => this.updateName(event)}
            />
          </FormGroup>
          <FormGroup controlId="formBasicText">
            <ControlLabel>Membership ID</ControlLabel>
            <FormControl
              type="text"
              value={this.state.id}
              placeholder="Enter your membership ID"
              onChange={event => this.updateId(event)}
            />
          </FormGroup>
          <FormGroup>
            <ControlLabel>Select the ladders you want to join</ControlLabel>
            {this.state.ladders.map((ladder, index) => {
              return (
                <Checkbox
                  onChange={event => this.updateCheckbox(event)}
                  name={ladder.name}
                >
                  {ladder.name}
                </Checkbox>
              );
            })}
          </FormGroup>
          <Button type="submit">Submit</Button>
        </form>
      </RegisterWindow>
    );
  }
}

const RegisterWindow = styled.div`
  width: 90%;
  margin: 0 auto;
  background-color: #ededed;
  padding: 2rem;
  margin-top: 2rem;
`;

export default RegisterForm;
