package de.metas.email;

import javax.annotation.Nullable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

/*
 * #%L
 * de.metas.adempiere.adempiere.base
 * %%
 * Copyright (C) 2019 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

@EqualsAndHashCode
public final class EMailCustomType
{
	public static EMailCustomType ofNullableCode(@Nullable final String code)
	{
		return code != null ? EMailCustomType.ofCode(code) : null;
	}

	public static EMailCustomType ofCode(@NonNull final String code)
	{
		return new EMailCustomType(code);
	}

	@Getter
	private final String code;

	private EMailCustomType(@NonNull final String code)
	{
		this.code = code;
	}

	@Deprecated
	@Override
	public String toString()
	{
		return getCode();
	}
}
