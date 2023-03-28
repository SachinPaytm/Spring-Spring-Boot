
import {PropTypes} from 'prop-types'

export default function Button({incrementBy,incrementFunction,decrementFunction}) {

    return (
        <div className="Button">
            <div>
                <button className="Button"
                    onClick={
                        () => incrementFunction(incrementBy)
                    }
                > +{incrementBy}
                </button>

                <button className="Button"
                    onClick={
                        () => decrementFunction(incrementBy)
                    }
                > -{incrementBy}
                </button>

            </div>
        </div>
    )
}


Button.propTypes = {
    incrementBy: PropTypes.number
}

Button.defaultProps = {
    incrementBy: 100
}