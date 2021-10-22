import { convert, LocalDateTime } from '@js-joda/core'

const options = {
  weekday: 'long',
  year: 'numeric',
  month: 'long',
  day: 'numeric',
  hour: 'numeric',
  minute: '2-digit',
}

export const convertToReadableDate = timestamp => {
  const dt = LocalDateTime.parse(timestamp)
  const jsDate = convert(dt).toDate()
  return jsDate.toLocaleDateString('en-US', options)
}
