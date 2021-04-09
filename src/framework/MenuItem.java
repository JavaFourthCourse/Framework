package framework;

abstract public class MenuItem implements MenuItemCall
{
	private String description;
	private String accessCommand;
	
	public MenuItem(String description, String accessCommand)
	{
		this.description = description;
		this.accessCommand = accessCommand;
	}
	
	public final void setAccessCommand(String accessCommand)
	{
		this.accessCommand = accessCommand;
	}
	
	public final void setDescription(String description)
	{
		this.description = description;
	}
	
	public final String getAccessCommand()
	{
		return accessCommand;
	}
	
	public final String getDescription()
	{
		return description;
	}
	
	@Override
	public String toString()
	{
		return accessCommand + " " + description;
	}
}
