import java.util.ArrayList;
public class Creater 
{//hi
	private int frequencyRate;
	//private int spaceMax;
	private String[][] wordsearch=null;
	private String[][] test=null;
	private ArrayList<String> words=null;
	
	public Creater(String[][] wordsearch, ArrayList<String> words, int frequencyRate, int spaceMax)
	{
		this.wordsearch=wordsearch;
		this.words=words;
		this.frequencyRate=frequencyRate;
		//this.spaceMax=spaceMax;
		this.test=new String[wordsearch.length][wordsearch[0].length];
		for(int i=0;i<wordsearch.length;i++)
	    {
	        for(int j=0;j<wordsearch[i].length;j++)
	        {
	        	wordsearch[i][j]="-";
	        	test[i][j]="-";
	        }
	    }
	}
	public void Create()
	{
		for(int i=0; i<words.size();i++)
		{
			if(!(wordsearch.length<words.size())||!(wordsearch[i].length<words.size()))
			{
				for(int j=0;j<2147483647;j++)
				{
					int row=(int)(Math.random()*1000)%wordsearch.length;
					int column=(int)(Math.random()*1000)%wordsearch[i].length;
					int direction=(int)(Math.random()*10)%8;
					
					if(direction==0) // right
					{
						int location=0;
						int lengthLeft=words.get(i).length();
						for(int k=column;k<column+lengthLeft;k++)
						{
							if(k<0||k>=wordsearch[0].length)
							{
								k=2147483647;
								for(int d=0;d<test.length;d++)
								{
									for(int s=0;d<test[d].length;s++)
									{
										test[d][s]="-";
									}
								}
							}
							else
							{
								int numPerSpace=numOfletter();
								test[row][k]=words.get(i).substring(location, location+numPerSpace);
								location=+numPerSpace;
								lengthLeft=-numPerSpace+1;
							}
							if(k+1==column+lengthLeft)
							{
								for(int l=0;l<wordsearch.length;l++)
								{
									for(int u=0;u<wordsearch[l].length;u++)
									{
										if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
										{
											test[l][u]=wordsearch[l][u];
										}
										else
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													test[l][u]="-";
												}
											}
											l=wordsearch.length;
											u=wordsearch[0].length;
										}
										if((l+1==wordsearch.length)&&(u+1==wordsearch[0].length))
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
													{
														wordsearch[l][u]=test[l][u];
													}
												}
											}
										}
									}
								}
							}
						}
					}
					else if(direction==1) // left
					{
						int location=0;
						int lengthLeft=words.get(i).length();
						for(int k=column+lengthLeft;k>column;k--)
						{
							if(k<0||k>=wordsearch[0].length)
							{
								k=-2147483647;
								for(int d=0;d<test.length;d++)
								{
									for(int s=0;d<test[d].length;s++)
									{
										test[d][s]="-";
									}
								}
							}
							else
							{
								int numPerSpace=numOfletter();
								test[row][k]=words.get(i).substring(location, location+numPerSpace);
								location=+numPerSpace;
								lengthLeft=-numPerSpace+1;
							}
							if(k-1==column)
							{
								for(int l=0;l<wordsearch.length;l++)
								{
									for(int u=0;u<wordsearch[l].length;u++)
									{
										if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
										{
											test[l][u]=wordsearch[l][u];
										}
										else
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													test[l][u]="-";
												}
											}
											l=wordsearch.length;
											u=wordsearch[0].length;
										}
										if((l+1==wordsearch.length)&&(u+1==wordsearch[0].length))
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
													{
														wordsearch[l][u]=test[l][u];
													}
												}
											}
										}
									}
								}
							}
						}
					}
					else if(direction==2) // up
					{
						int location=0;
						int lengthLeft=words.get(i).length();
						for(int k=row+lengthLeft;k>row;k--)
						{
							if(k<0||k>=wordsearch[0].length)
							{
								k=-2147483647;
								for(int d=0;d<test.length;d++)
								{
									for(int s=0;s<test[d].length;s++)
									{
										test[d][s]="-";
									}
								}
							}
							else
							{
								int numPerSpace=numOfletter();
								test[k][column]=words.get(i).substring(location, location+numPerSpace);
								location=+numPerSpace;
								lengthLeft=-numPerSpace+1;
							}
							if(k-1==column)
							{
								for(int l=0;l<wordsearch.length;l++)
								{
									for(int u=0;u<wordsearch[l].length;u++)
									{
										if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
										{
											test[l][u]=wordsearch[l][u];
										}
										else
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													test[l][u]="-";
												}
											}
											l=wordsearch.length;
											u=wordsearch[0].length;
										}
										if((l+1==wordsearch.length)&&(u+1==wordsearch[0].length))
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
													{
														wordsearch[l][u]=test[l][u];
													}
												}
											}
										}
									}
								}
							}
						}
					}
					else if(direction==3) // down
					{
						int location=0;
						int lengthLeft=words.get(i).length();
						for(int k=row;k<row+lengthLeft;k++)
						{
							if(k<0||k>=wordsearch[0].length)
							{
								k=2147483647;
								for(int d=0;d<test.length;d++)
								{
									for(int s=0;d<test[d].length;s++)
									{
										test[d][s]="-";
									}
								}
							}
							else
							{
								int numPerSpace=numOfletter();
								test[k][column]=words.get(i).substring(location, location+numPerSpace);
								location=+numPerSpace;
								lengthLeft=-numPerSpace+1;
							}
							if(k+1==column+lengthLeft)
							{
								for(int l=0;l<wordsearch.length;l++)
								{
									for(int u=0;u<wordsearch[l].length;u++)
									{
										if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
										{
											test[l][u]=wordsearch[l][u];
										}
										else
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													test[l][u]="-";
												}
											}
											l=wordsearch.length;
											u=wordsearch[0].length;
										}
										if((l+1==wordsearch.length)&&(u+1==wordsearch[0].length))
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
													{
														wordsearch[l][u]=test[l][u];
													}
												}
											}
										}
									}
								}
							}
						}
					}
					else if(direction==4) // upright
					{
						int location=0;  // know error "location" may reach an array out of bounce.
						int lengthLeft=words.get(i).length();
						for(int f=row+lengthLeft;f>row;f--)
						{
						for(int k=column;k<column+lengthLeft;k++)
						{
							if(k<0||k>=wordsearch[0].length||j<0||j>=wordsearch[0].length)
							{
								k=2147483647;
								f=-2147483647;
								for(int d=0;d<test.length;d++)
								{
									for(int s=0;d<test[d].length;s++)
									{
										test[d][s]="-";
									}
								}
							}
							else
							{
								int numPerSpace=numOfletter();
								test[f][k]=words.get(i).substring(location, location+numPerSpace);
								location=+numPerSpace;
								lengthLeft=-numPerSpace+1;
							}
							if(k+1==column+lengthLeft)
							{
								for(int l=0;l<wordsearch.length;l++)
								{
									for(int u=0;u<wordsearch[l].length;u++)
									{
										if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
										{
											test[l][u]=wordsearch[l][u];
										}
										else
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													test[l][u]="-";
												}
											}
											l=wordsearch.length;
											u=wordsearch[0].length;
										}
										if((l+1==wordsearch.length)&&(u+1==wordsearch[0].length))
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
													{
														wordsearch[l][u]=test[l][u];
													}
												}
											}
										}
									}
								}
							}
						}
						}
					}
					else if(direction==5) // upleft
					{
						int location=0;
						int lengthLeft=words.get(i).length();
						for(int f=row+lengthLeft;f>row;f--)
						{
						for(int k=column+lengthLeft;k>column;k--)
						{
							if(k<0||k>=wordsearch[0].length||j<0||j>=wordsearch[0].length)
							{
								k=2147483647;
								j=-2147483647;
								for(int d=0;d<test.length;d++)
								{
									for(int s=0;d<test[d].length;s++)
									{
										test[d][s]="-";
									}
								}
							}
							else
							{
								int numPerSpace=numOfletter();
								test[f][k]=words.get(i).substring(location, location+numPerSpace);
								location=+numPerSpace;
								lengthLeft=-numPerSpace+1;
							}
							if(k-1==column)
							{
								for(int l=0;l<wordsearch.length;l++)
								{
									for(int u=0;u<wordsearch[l].length;u++)
									{
										if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
										{
											test[l][u]=wordsearch[l][u];
										}
										else
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													test[l][u]="-";
												}
											}
											l=wordsearch.length;
											u=wordsearch[0].length;
										}
										if((l+1==wordsearch.length)&&(u+1==wordsearch[0].length))
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
													{
														wordsearch[l][u]=test[l][u];
													}
												}
											}
										}
									}
								}
							}
						}}
					}
					else if(direction==6) // downright
					{
						int location=0;
						int lengthLeft=words.get(i).length();
						for(int f=row;f<row+lengthLeft;f++)
						{
						for(int k=column;k<column+lengthLeft;k++)
						{
							if(k<0||k>=wordsearch[0].length||j<0||j>=wordsearch[0].length)
							{
								k=2147483647;
								j=2147483647;
								for(int d=0;d<test.length;d++)
								{
									for(int s=0;d<test[d].length;s++)
									{
										test[d][s]="-";
									}
								}
							}
							else
							{
								int numPerSpace=numOfletter();
								test[f][k]=words.get(i).substring(location, location+numPerSpace);
								location=+numPerSpace;
								lengthLeft=-numPerSpace+1;
							}
							if(k+1==column+lengthLeft)
							{
								for(int l=0;l<wordsearch.length;l++)
								{
									for(int u=0;u<wordsearch[l].length;u++)
									{
										if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
										{
											test[l][u]=wordsearch[l][u];
										}
										else
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													test[l][u]="-";
												}
											}
											l=wordsearch.length;
											u=wordsearch[0].length;
										}
										if((l+1==wordsearch.length)&&(u+1==wordsearch[0].length))
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
													{
														wordsearch[l][u]=test[l][u];
													}
												}
											}
										}
									}
								}
							}
						}
					}}
					else // downleft
					{
						int location=0;
						int lengthLeft=words.get(i).length();
						for(int f=row;f<row+lengthLeft;f++)
						{
						for(int k=column;k<column+lengthLeft;k++)
						{
							if(k<0||k>=wordsearch[0].length||j<0||j>=wordsearch[0].length)
							{
								k=2147483647;
								f=2147483647;
								for(int d=0;d<test.length;d++)
								{
									for(int s=0;d<test[d].length;s++)
									{
										test[d][s]="-";
									}
								}
							}
							else
							{
								int numPerSpace=numOfletter();
								test[f][k]=words.get(i).substring(location, location+numPerSpace);
								location=+numPerSpace;
								lengthLeft=-numPerSpace+1;
							}
							if(k+1==column+lengthLeft)
							{
								for(int l=0;l<wordsearch.length;l++)
								{
									for(int u=0;u<wordsearch[l].length;u++)
									{
										if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
										{
											test[l][u]=wordsearch[l][u];
										}
										else
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													test[l][u]="-";
												}
											}
											l=wordsearch.length;
											u=wordsearch[0].length;
										}
										if((l+1==wordsearch.length)&&(u+1==wordsearch[0].length))
										{
											for(int y=0;y<wordsearch.length;y++)
											{
												for(int g=0;g<wordsearch[y].length;g++)
												{
													if(wordsearch[l][u].equals("-")||wordsearch[l][u].equals(test[l][u]))
													{
														wordsearch[l][u]=test[l][u];
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}}
			else
			{
				Tools.prtln(words.get(i)+" is too big.");
			}
		}
	}
	public void created()
	{
		for(int i=0;i<wordsearch.length;i++)
	    {
	        Tools.prt("|");
	        for(int j=0;j<wordsearch[i].length;j++)
	        {
	            Tools.prt(""+wordsearch[i][j]);
	        }
	        Tools.prtln("|");
	    }
	}
	private int numOfletter()
	{
		double ram=Math.random();
		int num=1;
		for(int x=1;x!=0;x++)  //  1/100x
		{
			if(ram<=(1/(frequencyRate*x*100)))
			{
				num++;
			}
			else
			{
				x=-1;
			}
		}
		return num;
	}
}
