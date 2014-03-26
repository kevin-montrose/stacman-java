package com.stackexchange.stacman;

/**
 * StacMan API response
 */
public final class StacManResponse<T> {
    private boolean success;
    public boolean getSuccess(){ return success; }

    private Wrapper<T> data;
    public Wrapper<T> getData() { return data; }
    private void setData(Wrapper<T> newData) { data = newData; }

    private Exception error;
    public Exception getError() { return error; }
    private void setError(Exception newError) { error = newError; }

    public boolean getReceivedApiResponse() { return getData() != null; }

    public StacManResponse(Wrapper<T> data, Exception error) {
        setData(data);
        setError(error);

        success = error == null;
    }
}