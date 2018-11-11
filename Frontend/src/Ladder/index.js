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
      <tr>
        <th>Position</th>
        <th>Name</th>
        {isHiddenMMR ? null : <th>MMR</th>}
      </tr>
      {fencers.map((fencer, index) => {
        return(
          <tr>
            <td>{index + 1}.</td>
            <td>{fencer.name}</td>
            {isHiddenMMR ? null : <td>{fencer.MMR}</td>}
          </tr>
        )
      })}
    </table>
  )
}

export default Ladder;