package org.askerov.dynamicgrid;

public interface OnDragListenerGridView {
	public void onDragStarted(int position);
	public void onDragPositionsChanged(int oldPosition, int newPosition);
}
