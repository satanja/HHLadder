import React from 'react';

/**
 * Simple table with all the fencers of a specific ladder
 * Author: S.A. Tanja
 * Props:
 *  - fencers: array of fencer objects
 *  - isHiddenMMR: whether to draw the MMR in the table
 */
const Ladder = props => {
  const { fencers, isHiddenMMR } = props.response;
  return (
    <table>
      <thead>
        <tr>
          <th>Position</th>
          <th>Name</th>
          {isHiddenMMR ? null : <th>MMR</th>}
        </tr>
      </thead>
      <tbody>
        {fencers.map((fencer, index) => {
          const position = `${index + 1}.`;
          const { name, MMR } = fencer;
          return(
            <tr key={position}>
              <td>{position}</td>
              <td>{name}</td>
              {isHiddenMMR ? null : <td>{MMR}</td>}
            </tr>
          )
        })}
      </tbody>
      </table>
  )
}

export default Ladder;