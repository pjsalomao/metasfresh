package org.adempiere.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.adempiere.util.lang.IAutoCloseable;

/*
 * #%L
 * de.metas.util
 * %%
 * Copyright (C) 2015 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

/**
 * Holds the {@link ILoggable} instance of current thread.
 * 
 * @author metas-dev <dev@metas-fresh.com>
 *
 */
public final class ThreadLocalLoggableHolder
{
	/**
	 * Temporary set the current thread level loggable to given one.
	 * 
	 * The method is designed to be used in try-with-resources block, so the previous thread level loggable will be restored when the returned closeable will be closed.
	 * 
	 * @param loggable
	 * @return
	 */
	public IAutoCloseable temporarySetLoggable(final ILoggable loggable)
	{
		Check.assumeNotNull(loggable, "loggable not null");
		final ILoggable loggableOld = loggableRef.get();

		loggableRef.set(loggable);
		return new IAutoCloseable()
		{
			boolean closed = false;

			@Override
			public void close()
			{
				if (closed)
				{
					return;
				}
				closed = true;

				loggableRef.set(loggableOld);
			}

		};
	}

	/** @return current thread's {@link ILoggable} instance or null */
	public ILoggable getLoggable()
	{
		return loggableRef.get();
	}

	/** @return current thread's {@link ILoggable} instance or <code>defaultLoggable</code> if there was no thread level {@link ILoggable} */
	public ILoggable getLoggableOr(final ILoggable defaultLoggable)
	{
		final ILoggable loggable = loggableRef.get();
		return loggable != null ? loggable : defaultLoggable;
	}

	/** @return current thread's {@link ILoggable} instance or a {@link JULLoggable} instance if there was no thread level {@link ILoggable} */
	public ILoggable getLoggableOrLogger(final Logger logger, final Level logLevel)
	{
		final ILoggable loggable = loggableRef.get();
		if (loggable != null)
		{
			return loggable;
		}

		return new JULLoggable(logger, logLevel);
	}

	public static final transient ThreadLocalLoggableHolder instance = new ThreadLocalLoggableHolder();

	private final ThreadLocal<ILoggable> loggableRef = new ThreadLocal<>();

	private ThreadLocalLoggableHolder()
	{
		super();
	}
}
