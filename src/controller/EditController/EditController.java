package controller.EditController;

import view.Edit;

public class EditController {
	private Edit editView;

	public EditController(Edit editView) {
		super();
		this.editView = editView;
		this.editView.addHoanTatMouseListener(new HoanTatMouseListener(editView));
		this.editView.addHuyMouseListener(new HuyMouseListener(editView));
	}
}
