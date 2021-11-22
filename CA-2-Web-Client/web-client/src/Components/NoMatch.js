import { useLocation } from 'react-router-dom';

function NoMatch() {
    // eslint-disable-next-line no-undef
    let location = useLocation();

    return (
        <div>
            <h2 className="mt-3">No match for <code>{location.pathname}</code></h2>
        </div>
    );
}

export default NoMatch;