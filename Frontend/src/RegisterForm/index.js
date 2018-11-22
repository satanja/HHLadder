import React, { Component } from "react";
import {
  FormGroup,
  ControlLabel,
  FormControl,
  Checkbox,
  Button
} from "react-bootstrap";
import styled from "styled-components";
import Window from "../Window";

class RegisterForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      id: "",
      ladders: props.ladders.map(ladder => {
        const obj = {
          name: ladder.name,
          isSelected: false
        };
        return obj;
      })
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

  updateCheckbox(event) {
    const { checked, name } = event.target;
    this.setState(prevState => ({
      ...prevState,
      ladders: prevState.ladders.map(ladder => {
        if (ladder.name === name) {
          return Object.assign(ladder, { isSelected: checked });
        } else {
          return ladder;
        }
      })
    }));
  }

  onSubmit(event) {
    const ladders = this.state.ladders;
    const selectedLadders = ladders.filter(ladder => {
      return ladder.isSelected;
    });
    const message = {
      command: "add",
      name: this.state.name,
      ladders: selectedLadders.map(ladder => {
        return { name: ladder.name };
      })
    };
    this.props.onSubmit(message);
  }

  render() {
    return (
      <Window>
        <Caption>Register</Caption>
        <form>
          <FormGroup controlId="formName">
            <ControlLabel>Name</ControlLabel>
            <FormControl
              type="text"
              autoComplete="off"
              value={this.state.name}
              placeholder="Enter your name"
              onChange={event => this.updateName(event)}
            />
          </FormGroup>
          <FormGroup controlId="formId">
            <ControlLabel>Membership ID</ControlLabel>
            <FormControl
              type="number"
              autoComplete="off"
              value={this.state.id}
              placeholder="Enter your membership ID"
              onChange={event => this.updateId(event)}
            />
          </FormGroup>
          <FormGroup controlId="formLadder">
            <ControlLabel>Select the ladders you want to join</ControlLabel>
            {this.state.ladders.map((ladder, index) => {
              return (
                <Checkbox
                  onChange={event => this.updateCheckbox(event)}
                  name={ladder.name}
                  key={index}
                >
                  {ladder.name}
                </Checkbox>
              );
            })}
          </FormGroup>
          <Button type="submit" onClick={() => this.onSubmit()}>
            Submit
          </Button>
        </form>
      </Window>
    );
  }
}
const Caption = styled.p`
  text-align: center;
`;

export default RegisterForm;
