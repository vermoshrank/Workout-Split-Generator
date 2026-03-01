package persistence;

import org.json.JSONObject;

// based off WorkRoom application

/**
 * An interface to be implemented by any model class that needs to be
 * converted to JSON for persistence.
 */
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}

