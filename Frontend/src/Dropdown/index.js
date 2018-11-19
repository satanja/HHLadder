import React from 'react';

/**
 * Simple dropdown template
 * Author: S.A. Tanja
 * Props:
 *  - values The selectable values
 *  - required Whether you are required to select a value
 *  - requiredText The text to notify the user to select a value
 */
const Dropdown = props => {
  const { values, className, required, requiredText } = props;
  return(
    <select
      className={className}
      onChange={event => props.onChange(event)}
      required={required}
    >
      {required? null: <option disabled selected value>{requiredText}</option>}
      {values.map(value => {
        return <option key={value}>{value}</option>
      })}  
    </select>
  );  
}

export default Dropdown;  